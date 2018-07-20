@file:JvmName("FormatIt")

package lib.siddharth.formatitlib

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class FormatIt {

    companion object {
        @JvmStatic fun changeFormat(dateInString: String, currentFormat: String, targetFormat: String) : String? {
            val inputFormat = SimpleDateFormat(currentFormat, Locale.getDefault())
            val outputFormat = SimpleDateFormat(targetFormat, Locale.getDefault())
            val date: Date?
            var str: String? = null
            try {
                date = inputFormat.parse(dateInString)
                str = outputFormat.format(date)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return str
        }

        @JvmStatic fun changeTimeZone(dateInString: String, differenceFromGMT: String, currentFormat: String, targetFormat: String) : String {
            val inputFormat = SimpleDateFormat(currentFormat, Locale.getDefault())
            inputFormat.timeZone = TimeZone.getTimeZone("GMT")
            val defaultDate = inputFormat.parse(dateInString)
            val outputFormat = SimpleDateFormat(targetFormat, Locale.getDefault())
            outputFormat.timeZone = TimeZone.getTimeZone("GMT$differenceFromGMT")
            return outputFormat.format(defaultDate)
        }

        @JvmStatic fun changeTimeZone(dateInString: String, differenceFromGMT: String, timeFormat: String) : String {
            val inputFormat = SimpleDateFormat(timeFormat, Locale.getDefault())
            inputFormat.timeZone = TimeZone.getTimeZone("GMT")
            val defaultDate = inputFormat.parse(dateInString)
            val outputFormat = SimpleDateFormat(timeFormat, Locale.getDefault())
            outputFormat.timeZone = TimeZone.getTimeZone("GMT$differenceFromGMT")
            return outputFormat.format(defaultDate)
        }

    }

}
