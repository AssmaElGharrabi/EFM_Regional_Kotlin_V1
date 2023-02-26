class Dict {

    var listEntree: ArrayList<Ent> = arrayListOf()

    fun nombreEntrees(): Int {
        return listEntree.size
    }

    fun ajouter(e: Ent) {
        if (listEntree.contains(e)) {
            throw Exception("appartient déjà au dictionnaire")
        } else listEntree.add(e)
    }

    fun supprimer(e: Ent): Boolean {
        if (listEntree.contains(e)) {
            listEntree.remove(e)
            return true
        } else {
            throw Exception("n’existe pas")
            return false
        }
    }

    fun supprimer(motAnglais: String) : Boolean{
        var etat : Boolean = false
        for (e in listEntree){
            if (e.motAnglais == motAnglais){
                listEntree.remove(e)
                etat = true
            }else {
                throw Exception("n’existe pas")
                etat = false
            }
        }
        return etat
    }

    fun frAn(motFrancais : String) : ArrayList<String> {
        val motAng = arrayListOf<String>()
        for (e in listEntree) {
            if (e.motFrancais == motFrancais) {
                motAng.add(e.motAnglais)
            }
        }
        return motAng
    }

    fun motsFrancais(): Set<String> {
        return listEntree.map { it.motFrancais }.toSet()
    }

    fun dictionnaireFrAn(): Map<String, ArrayList<String>>{
        val dict = HashMap<String, ArrayList<String>>()
        for (e in listEntree) {
            val motAng = dict.getOrDefault(e.motFrancais, ArrayList())
            motAng.add(e.motAnglais)
            dict[e.motFrancais] = motAng
        }
        return dict
    }

    override fun toString() : String{
        val str = StringBuilder()
        for (e in listEntree) {
            str.append(e.toString())
            str.append("\n")
        }
        return str.toString()
    }

}