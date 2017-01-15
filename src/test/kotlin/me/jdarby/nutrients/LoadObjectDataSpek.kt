package me.jdarby.nutrients

import com.winterbe.expekt.should
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object LoadObjectDataSpek : Spek({

    given("a collection of FOOD_DES_object records") {
        val FOOD_DES_objects = load_FOOD_DES_object()
        on("counting the records") {
            val size = FOOD_DES_objects.size
            it("has 8789 records") {
                size.should.equal(8789)
            }
        }
    }

})