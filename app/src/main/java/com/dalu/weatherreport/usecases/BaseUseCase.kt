package com.dalu.weatherreport.usecases

import io.reactivex.Single

class BaseUseCase {
    interface NoParamUseCase<Result> {
        fun getAction(): Single<Result>
    }

    interface ParamUseCase<Params, Result> {
        fun getAction(params: Params): Single<Result>?
    }
}