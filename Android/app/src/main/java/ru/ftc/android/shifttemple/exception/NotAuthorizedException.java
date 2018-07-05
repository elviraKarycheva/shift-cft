package ru.ftc.android.shifttemple.exception;

public final class NotAuthorizedException extends IllegalStateException   {

    public NotAuthorizedException() {
        super("Authorization required");
    }
}
