import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.ZoneOffset

String transformDateToISO8601String(ZonedDateTime dateTime) {
    return DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(dateTime.withZoneSameInstant(ZoneOffset.UTC));
}

ZonedDateTime transformISO8601StringToDate(String value) {
    return ZonedDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
}

def now = ZonedDateTime.now()
def oneDaysAgo = now.minusDays(1)

def nowISO8601 = transformDateToISO8601String(now)
println nowISO8601 // in ISO 8601 format
println transformISO8601StringToDate(nowISO8601) // println Date object

println transformDateToISO8601String(oneDaysAgo)

println java.time.temporal.ChronoUnit.SECONDS.between(oneDaysAgo, now)

println now > oneDaysAgo