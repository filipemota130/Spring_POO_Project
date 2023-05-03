package com.system.manage.command;

public interface Command<T> {
    abstract void execute(T a);
}
