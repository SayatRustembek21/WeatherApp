package kz.sayat.weatherapp.domain

interface Mapper<FROM, TO> {
    fun map(from: FROM): TO
}