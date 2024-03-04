const val BUY_ESPRESSO = "1"
const val BUY_LATTE = "2"
const val BUY_CAPPUCCINO = "3"

const val ESPRESSO_PRICE = 4
const val LATTE_PRICE = 7
const val CAPPUCCINO_PRICE = 6  

fun machineStatus(water: Int, milk: Int, beans: Int, cups: Int, money: Int): Unit {
    println("The coffee machine has:")
    println("$water ml of water")
    println("$milk ml of milk")
    println("$beans g of coffee beans")
    println("$cups disposable cups")
    println("$$money of money")
}

fun main() {
    var water = 400
    var milk = 540
    var beans = 120
    var cups = 9
    var money = 550

    var action = ""

    while (true) {
        println("Write action (buy, fill, take, remaining, exit):")
        action = readln()
        
        if (action == "buy" || action == "1") {
            println("What do you want to buy?")
            var buyOption = readln().toString()
            
            if (buyOption == BUY_ESPRESSO) {
                if (water >= 250 && beans >= 16 && cups >= 1) {
                    println("I have enough resources, making you a coffee!")
                    water -= 250
                    beans -= 16
                    cups--
                    money += ESPRESSO_PRICE
                } else {
                    if (water < 250) {
                        println("Sorry, not enough water!")
                    } else if (beans < 16) {
                        println("Sorry, not enough coffee beans!")
                    } else if (cups < 1) {
                        println("Sorry, not enough disposable cups!")    
                    }
                }
                
            } else if (buyOption == BUY_LATTE) {
                if (water >= 350 && milk >= 75 && beans >= 20 && cups >= 1) {
                    println("I have enough resources, making you a coffee!")
                    water -= 350
                    milk -= 75
                    beans -= 20
                    cups--
                    money += LATTE_PRICE
                } else {
                    if (water < 350) {
                        println("Sorry, not enough water!")
                    } else if (milk < 75) {
                        println("Sorry, not enough milk!")
                    } else if (beans < 20) {
                        println("Sorry, not enough coffee beans!")
                    } else if (cups < 1) {
                        println("Sorry, not enough disposable cups!")    
                    }
                }
                
            } else if (buyOption == BUY_CAPPUCCINO) {
                if (water >= 200 && milk >= 100 && beans >= 12 && cups >= 1) {
                    println("I have enough resources, making you a coffee!")
                    water -= 200
                    milk -= 100
                    beans -= 12
                    cups--
                    money += CAPPUCCINO_PRICE
                } else {
                    if (water < 200) {
                        println("Sorry, not enough water!")
                    } else if (milk < 100) {
                        println("Sorry, not enough milk!")
                    } else if (beans < 12) {
                        println("Sorry, not enough coffee beans!")
                    } else if (cups < 1) {
                        println("Sorry, not enough disposable cups!")    
                    }
                }
                
            } else if (buyOption == "back") {
                   if (buyOption == BUY_ESPRESSO) {
                        water += 250
                        beans += 16
                        cups++
                        money -= ESPRESSO_PRICE
                   } else if (buyOption == BUY_LATTE) {
                        water += 350
                        milk += 75
                        beans += 20
                        cups++
                        money -= LATTE_PRICE
                   } else if (buyOption == BUY_CAPPUCCINO) {
                        water += 200
                        milk += 100
                        beans += 12
                        cups++
                        money -= CAPPUCCINO_PRICE
                   }
                }
        } else if (action == "fill" || action == "2") {
            println("Write how many ml of water you want to add:")
            val addWater = readln().toInt()

            println("Write how many ml of milk you want to add:")
            val addMilk = readln().toInt()

            println("Write how many grams of coffee beans you want to add:")
            val addBeans = readln().toInt()

            println("Write how many disposable cups you want to add:")
            val addCups = readln().toInt()
        
            water += addWater
            milk += addMilk
            beans += addBeans
            cups += addCups
        
        } else if (action == "take" || action == "3") {
            println("I gave you $$money")
            money = 0
        
        } else if (action == "remaining" || action == "4") {
            machineStatus(water, milk, beans, cups, money)
        } else if (action == "exit" || action == "5") {
            return
        }
    }
}
