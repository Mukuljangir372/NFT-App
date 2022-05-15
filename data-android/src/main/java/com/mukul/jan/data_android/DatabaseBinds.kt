package com.mukul.jan.data_android

import com.mukul.jan.data.NftDatabase
import com.mukul.jan.data_android.utils.Const
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
abstract class DatabaseBinds {

    @Binds
    abstract fun bindNftDatabase(
        @Named(Const.NFT_ROOM_DATABASE) nftAppDatabase: NftAppDatabase
    ): NftDatabase

}