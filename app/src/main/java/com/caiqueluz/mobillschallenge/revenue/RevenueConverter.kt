package com.caiqueluz.mobillschallenge.revenue

import android.content.res.Resources
import br.com.concrete.canarinho.formatador.FormatadorValor
import com.caiqueluz.mobillschallenge.DateConverter
import com.caiqueluz.mobillschallenge.R

class RevenueConverter(
    private val dateConverter: DateConverter,
    private val resources: Resources
) {

    fun convert(revenues: List<Revenue>): List<RevenueVO> =
        revenues.map { revenue ->
            val value: String =
                FormatadorValor.VALOR_COM_SIMBOLO
                    .formata(revenue.value.toString())

            RevenueVO(
                value = value,
                description = revenue.description,
                date = dateConverter.convert(revenue.date),
                received = getReceivedValue(revenue)
            )
        }

    private fun getReceivedValue(revenue: Revenue): String =
        if (revenue.received) {
            resources.getString(R.string.revenue_received_value)
        } else {
            resources.getString(R.string.revenue_not_received_value)
        }
}
