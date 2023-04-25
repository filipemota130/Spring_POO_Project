package com.system.manage.controllers;

public interface Command<T> {
    abstract String executar(T a);
}
