package com.caiqueluz.mobillschallenge

class TabItemFactory {

    fun createItems(): List<TabItemVO> = listOf(
        TabItemVO("Início", HomeFragment()),
        TabItemVO("Despesas", FirstFragment()),
        TabItemVO("Receitas", SecondFragment())
    )
}
