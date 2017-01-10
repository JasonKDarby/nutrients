package me.jdarby.nutrients

import com.winterbe.expekt.should
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object LoadFileDataSpek : Spek({

    given("a collection of DATA_SRC records") {
        val DATA_SRC = load_DATA_SRC()
        on("counting the records") {
            val size = DATA_SRC.size
            it("has 681 records") {
                size.should.equal(681)
            }
        }
    }

    given("a collection of DATSRCLN records") {
        val DATSRCLN = load_DATSRCLN()
        on("counting the records") {
            val size = DATSRCLN.size
            it("has 244496 records") {
                size.should.equal(244496)
            }
        }
    }

    given("a collection of DERIV_CD records") {
        val DERIV_CD = load_DERIV_CD()
        on("counting the records") {
            val size = DERIV_CD.size
            it("has 55 records") {
                size.should.equal(55)
            }
        }
    }

    given("a collection of FD_GROUP records") {
        val FD_GROUP = load_FD_GROUP()
        on("counting the records") {
            val size = FD_GROUP.size
            it("has 25 records") {
                size.should.equal(25)
            }
        }
    }

    given("a collection of FOOD_DES records") {
        val FOOD_DES = load_FOOD_DES()
        on("counting the records") {
            val size = FOOD_DES.size
            it("has 8789 records") {
                size.should.equal(8789)
            }
        }
    }

    given("a collection of FOOTNOTE records") {
        val FOOTNOTE = load_FOOTNOTE()
        on("counting the records") {
            val size = FOOTNOTE.size
            it("has 553 records") {
                size.should.equal(553)
            }
        }
    }

    given("a collection of LANGDESC records") {
        val LANGDESC = load_LANGDESC()
        on("counting the records") {
            val size = LANGDESC.size
            it("has 774 records") {
                size.should.equal(774)
            }
        }
    }

    given("a collection of LANGUAL records") {
        val LANGUAL = load_LANGUAL()
        on("counting the records") {
            val size = LANGUAL.size
            it("has 38301 records") {
                size.should.equal(38301)
            }
        }
    }

    given("a collection of NUT_DATA records") {
        val NUT_DATA = load_NUT_DATA()
        on("counting the records") {
            val size = NUT_DATA.size
            it("has 679045 records") {
                size.should.equal(679045)
            }
        }
    }

    given("a collection of NUTR_DEF records") {
        val NUTR_DEF = load_NUTR_DEF()
        on("counting the records") {
            val size = NUTR_DEF.size
            it("has 150 records") {
                size.should.equal(150)
            }
        }
    }

    given("a collection of SRC_CD records") {
        val SRC_CD = load_SRC_CD()
        on("counting the records") {
            val size = SRC_CD.size
            it("has 10 records") {
                size.should.equal(10)
            }
        }
    }

    given("a collection of WEIGHT records") {
        val WEIGHT = load_WEIGHT()
        on("counting the records") {
            val size = WEIGHT.size
            it("has 15438 records") {
                size.should.equal(15438)
            }
        }
    }

})
