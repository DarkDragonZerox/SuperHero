package cl.darkdragonzerox.superheroes.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.*
import timber.log.Timber

@Dao
interface SuperHeroDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun loadHeros(countries: List<SuperHero>)

    @Query("SELECT * FROM superhero")
    fun getSuperHero(): LiveData<List<SuperHero>>


}

@Database(entities = [SuperHero::class], version = 1)
@TypeConverters(Converters::class)
abstract class SuperHeroDatabase : RoomDatabase() {
    abstract fun superHeroDao(): SuperHeroDao
}

class SuperHeroApplication : Application() {
    companion object {
        var superHeroDatabase: SuperHeroDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()

        superHeroDatabase =
            Room.databaseBuilder(this, SuperHeroDatabase::class.java, "db_superHero").build()
    }
}