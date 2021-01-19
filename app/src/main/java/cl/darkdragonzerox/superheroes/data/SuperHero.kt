package cl.darkdragonzerox.superheroes.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "superhero")
data class SuperHero(@PrimaryKey val id: Int,
                     val name:String,
                     val slug:String,
                     @Embedded  val powerstats:PowerStats,
                     @Embedded  val appearance :Appearance,
                     @Embedded val biography: Biography,
                     @Embedded val connections: Connections,
                     @Embedded val work:Work,
                     @Embedded  val images:Images

                    )
data class PowerStats(val intelligence:Int,
                      val strength:Int,
                      val speed:Int,
                      val durability:Int,
                      val power:Int,
                      val combat:Int

                      )
data class Appearance(val gender: String,
                      val race : String,
                      val height :List<String>,
                      val weight :List<String>,
                      val eyeColor :String,
                      val hairColor :String,

                      )
data class Biography (val fullName: String,
                      val alterEgos: String,
                      val aliases: List<String>,
                      val placeOfBirth: String,
                      val firstAppearance: String,
                      val publisher: String,
                      val alignment: String,
                      )
data class Connections(val groupAffiliation: String,
                       val relatives: String,
                       )
data class Work(val occupation: String,
                val base: String,)
data class Images(val xs:String,
                  val sm:String,
                  val md:String,
                  val lg:String,

)




