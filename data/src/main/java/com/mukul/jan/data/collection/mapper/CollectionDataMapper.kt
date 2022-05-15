package com.mukul.jan.data.collection.mapper

import com.mukul.jan.data.collection.local.Collection
import com.mukul.jan.data.collection.network.NetworkCollection
import org.mapstruct.Mapper
import org.mapstruct.NullValueCheckStrategy
import org.mapstruct.NullValueMappingStrategy
import org.mapstruct.NullValuePropertyMappingStrategy

@Mapper(
    nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT,
    nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
interface CollectionDataMapper {

    fun networkCollectionListToCollectionList(list: List<NetworkCollection>) : List<Collection>

}