data class Ent (var motFrancais : String, var motAnglais : String){

    init {
        if (motFrancais.isEmpty() || motFrancais.isBlank()) throw Exception("Le mot français ne peut pas être empty ou blank")
        if (motAnglais.isEmpty() || motAnglais.isBlank()) throw Exception("Le mot anglais ne peut pas être empty or blank")
    }

    override fun toString(): String {
        return "$motFrancais : $motAnglais"
    }

    fun equals(other: Ent): Boolean {
        if (this.motAnglais === other.motAnglais) {
            return true
        }
        return false
    }
}