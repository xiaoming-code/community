package life.majiang.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode
{
    QUESTION_NOT_FOUND(2001,"你找的问题不在啦!,要不换个试试?"),
    TARGET_PARAM_NOT_FOUND(2002,"未选择任何问题或评论进行回复"),
    NO_LOGIN(2003,"需要登录后才能进行评论,请先登录"),
    SYS_ERROR(2004,"需要登录后才能进行评论,请先登录"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006, "你所回复的评论不存在"),
    CONTENT_IS_EMPTY(2007, "评论内容不能为空");
    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message)
    {
        this.code = code;
        this.message = message;
    }


    @Override
    public String getMessage()
    {
        return message;
    }

    @Override
    public Integer getCode()
    {
        return code;
    }
}
