package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


interface LiveDataWrapper {

    fun save(bundleWrapper: BundleWrapper.Save)

    fun liveData(): LiveData<UiState>

    fun update(uiState: UiState)

    class Base(
        private val liveData: MutableLiveData<UiState> = SingleLiveEvent()
    ) : LiveDataWrapper {

        override fun save(bundleWrapper: BundleWrapper.Save) {
            liveData.value?.let {
                bundleWrapper.save(it)
            }
        }

        override fun liveData(): LiveData<UiState> = liveData

        override fun update(uiState: UiState) {
            liveData.value = uiState
        }
    }
}
