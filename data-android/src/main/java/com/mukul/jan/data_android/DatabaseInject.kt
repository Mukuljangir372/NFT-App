package com.mukul.jan.data_android

import android.content.Context
import androidx.room.Room
import com.mukul.jan.data_android.utils.Const.NFT_ROOM_DATABASE
import com.mukul.jan.data_android.utils.Const.NFT_ROOM_DB
import com.mukul.jan.data_android.utils.Const.NFT_ROOM_DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseInject {

    @Singleton
    @Provides
    @Named(NFT_ROOM_DB_NAME)
    fun nftDatabaseName(): String = NFT_ROOM_DB

    @Singleton
    @Provides
    @Named(NFT_ROOM_DATABASE)
    fun nftAppDatabase(
        @ApplicationContext appContext: Context,
        @Named(NFT_ROOM_DB_NAME) dbName: String,
    ): NftAppDatabase {
        return Room.databaseBuilder(
            appContext,
            NftAppDatabase::class.java,
            dbName
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }


}






