package com.confy.domain;

import java.util.Objects;
import java.util.function.Function;

public class Result<T> {

    private Result() {

    }

    public static <T> Result<T> success(T value) {
        return new Success<>(value);
    }

    public static <T> Result<T> failure(Throwable exception) {
        return new Failure<>(exception);
    }

    private static class Success<T> extends Result<T> {

        private final T value;

        Success(T value) {
            this.value = value;
        }

    }

    private static class Failure<T> extends Result<T> {

        private final Throwable exception;

        Failure(Throwable exception) {
            this.exception = exception;
        }

    }

    public Boolean isSuccess = this instanceof Success<?>;

    public Boolean isFailure = this instanceof Failure<?>;

    public T getOrNull() {
        T value;
        if (isSuccess) {
            Success<T> result = (Success<T>) this;
            value = result.value;
        } else {
            value = null;
        }
        return value;
    }

    public T getOrDefault(T defaultValue) {
        T value;
        if (isSuccess) {
            Success<T> result = (Success<T>) this;
            value = result.value;
        } else {
            value = defaultValue;
        }
        return value;
    }

    public Throwable exceptionOrNull() {
        Throwable value;
        if (isFailure) {
            Failure<T> result = (Failure<T>) this;
            value = result.exception;
        } else {
            value = null;
        }
        return value;
    }

    public <R> Result<R> map(Function<? super T, ? extends R> mapper) {
        if (isSuccess) {
            T value = ((Success<T>) this).value;
            return Result.success(mapper.apply(value));
        } else {
            Throwable exception = ((Failure<T>) this).exception;
            return new Failure<R>(exception);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result<?> result = (Result<?>) o;
        return Objects.equals(isSuccess, result.isSuccess) &&
                Objects.equals(isFailure, result.isFailure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isSuccess, isFailure);
    }
}
