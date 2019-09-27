function comment2target(targetId,type,content)
{
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
            "parentId":targetId,
            "content":content,
            "type":type
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



/*提交回复*/
function post()
{
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    comment2target(questionId,1,content);
}

/*评论已有的评论*/
function comment(e)
{
    var commentId = e.getAttribute("data-id");
    var content = $("#input-"+commentId).val();
    comment2target(commentId,2,content);
}


/*展开二级评论*/
function collapseComments(e)
{
    var id = e.getAttribute("data-id");
    var comments = $("#comment-"+id);

    //获取二级评论的展开状态
    var collapse = e.getAttribute("data-collapse");
    if(collapse)
    {
        //折叠二级评论,并移除展开状态
        comments.removeClass("in");
        e.removeAttribute("data-collapse");
        e.classList.remove("active");
    }
    else
    {
        var subCommentContainer = $("#comment-"+id);
        if (subCommentContainer.children().length == 1) {
            $.getJSON("/comment/" + id, function (data) {
                //请求数据成功，得到二级评论列表,拼凑标签
                $.each(data.data, function (index, comment) {
                    console.log(comment);

                    var mediaLeftElement = $("<div/>",{
                        "class":"media-left"
                    }).append($("<img/>", {
                        "class": "media-object img-rounded",
                        "src": comment.user.avatarUrl
                    }));

                    var mediaBodyElement = $("<div/>",{
                        "class":"media-body"
                    }).append($("<h5/>", {
                        "class": "media-heading",
                        html: comment.user.name
                    })).append($("<span/>", {
                        "class": "sub_content",
                        html: comment.content
                    })).append($("<div/>", {
                        "class": "act-info"
                    }).append($("<span/>", {
                        "class": "pull-right",
                        html: moment(comment.gmtCreate).format('YYYY-MM-DD HH:mm')
                    })));

                    var commentElement = $("<div/>", {
                        "class": "media comment-list sub_list",
                    }).append(mediaLeftElement).append(mediaBodyElement);

                    subCommentContainer.prepend(commentElement);
                });
                //展开二级评论,添加展开状态
                comments.addClass("in");
                e.setAttribute("data-collapse", "in");
                e.classList.add("active");
            });

        } else {
            comments.addClass("in");
            e.setAttribute("data-collapse", "in");
            e.classList.add("active");
        }
    }

}

function selectTag(e)
{
    var value = e.getAttribute("data-tag");
    var previous = $("#tag").val();

    if(previous.indexOf(value) == -1)
    {
        if(previous)
        {
            $("#tag").val(previous+','+value);
        }
        else
        {
            $("#tag").val(value);
        }
    }

}

function showSelectTag()
{
    $("#select-tag").show();
}


