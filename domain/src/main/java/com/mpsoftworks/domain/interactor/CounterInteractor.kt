package com.mpsoftworks.domain.interactor

import com.mpsoftworks.data.api.CounterDbApi
import com.mpsoftworks.data.model.Counter
import com.mpsoftworks.data.model.CounterGroup
import com.mpsoftworks.domain.model.InitialCountersData
import javax.inject.Inject
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * Interactor of counter. Mekes basic interoperability with data layer.
 * should be abstracted when needs to be synced with server.
 */
@OptIn(ExperimentalUuidApi::class)
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

    fun updateCounter(counter: Counter, groupId: Uuid) =
        counterDbApi.addOrUpdateCounter(counter, groupId)

    fun createNewCounter(counter: Counter, groupId: Uuid) =
        counterDbApi.addOrUpdateCounter(counter, groupId)

    fun deleteCounters(counters: List<Counter>,  groupId: Uuid) =
        counterDbApi.deleteCounters(counters,  groupId)


    fun getCounters(groupId: Uuid) =
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