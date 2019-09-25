function post() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    if(!content)
    {
        alert("请输入评论内容！");
        return ;
    }

    $.ajax({
        type: "POST",
        url: "/comment",
        contentType:"application/json",
        data:JSON.stringify( {
            "parentId":questionId,
            "content":content,
            "type":1
        }),
        success: function (response) {
            if(response.code == 200)
            {
                window.location.reload();
            }
            else
            {
                if(response.code == 2003)
                {
                    var isAccepted = confirm("当前操作需要登录,是否立即登录");
                    if(isAccepted)
                    {
                        window.open("https://github.com/login/oauth/authorize?client_id=ffa1d65f1508ec305908&redirect_uri=http://localhost:8887/callback&scope=user&state=1")
                        window.localStorage.setItem("closable","true");
                    }
                }
            }
        },
        dataType: "json"
    });

}

