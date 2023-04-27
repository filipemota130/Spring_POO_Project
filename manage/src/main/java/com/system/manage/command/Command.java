package com.system.manage.command;

public interface Command <T>{
    abstract String executar(T a);
}
