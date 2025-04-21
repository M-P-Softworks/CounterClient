package com.mpsoftworks.domain.interactor

import com.mpsoftworks.data.api.CounterDbApi
import com.mpsoftworks.data.model.Counter
import com.mpsoftworks.data.model.CounterGroup
import com.mpsoftworks.domain.model.InitialCountersData
import java.util.UUID
import javax.inject.Inject

/**
 * Interactor of counter. Mekes basic interoperability with data layer.
 * should be abstracted when needs to be synced with server.
 */
class CounterInteractor @Inject constructor(
    private val counterDbApi: CounterDbApi
    // ToDo("add metrics")
) {

    fun getInitialData(): InitialCountersData {
        val groups = getGroups().getOrThrow()

        val counters = groups.map { group ->
            getCounters(group.id).getOrDefault(emptyList())
        }

        return InitialCountersData(groups, counters)
    }

    fun updateCounter(counter: Counter, groupId: UUID) =
        counterDbApi.addOrUpdateCounter(counter, groupId)

    fun createNewCounter(counter: Counter, groupId: UUID) =
        counterDbApi.addOrUpdateCounter(counter, groupId)

    fun deleteCounters(counters: List<Counter>,  groupId: UUID) =
        counterDbApi.deleteCounters(counters,  groupId)


    fun getCounters(groupId: UUID) =
        counterDbApi.getCounterList(groupId)

//-------------------------------------------------------------------------------------------------

    fun createNewGroup(group: CounterGroup) =
        counterDbApi.addOrUpdateGroup(group)

    fun updateGroup(group: CounterGroup) =
        counterDbApi.addOrUpdateGroup(group)

    fun deleteGroups(groups: List<CounterGroup>) =
        counterDbApi.deleteGroup(groups)

    fun getGroups() =
        counterDbApi.getGroups()

}