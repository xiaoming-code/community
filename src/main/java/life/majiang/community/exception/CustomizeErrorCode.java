package life.majiang.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode
{
    Question_Not_Found("你找的问题不在啦!,要不换个试试?");
    private String message;
    CustomizeErrorCode(String message)
    {
        this.message = message;
    }

    @Override
    public String getMessage()
    {
        return message;
    }
}
