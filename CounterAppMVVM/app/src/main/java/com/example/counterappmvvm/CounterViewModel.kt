package com.example.counterappmvvm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel() : ViewModel() {
    // _count apenas é acessavel dentro da classe CounterViewModel
    private val _repository: CounterRepository = CounterRepository()
    private val _count = mutableStateOf(_repository.getCounter().count)

    // Expor a count como um estado imutável
    val count:MutableState<Int> = _count


    fun increment(){
        _repository.incrementCounter()
        _count.value = _repository.getCounter().count
    }
    fun decrement(){
        _repository.decrementCounter()
        _count.value = _repository.getCounter().count
    }
}