package dto

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import model.Commit
import model.Issue
import model.Project
import javax.xml.bind.annotation.*

@XmlRootElement(name = "repository")
@XmlAccessorType(XmlAccessType.FIELD)
class RepositoryDTO (
        @XmlAttribute
        var id: String,
        var name: String,
        @XmlAttribute(name = "creation_date")
        var creationDate: String,
        var project: Project,
        @XmlElementWrapper
        var commits: List<Commit>?,
        @XmlElementWrapper
        var issues: List<Issue>?
) {
    fun fromJSON(json : String) : RepositoryDTO? {
        return Gson().fromJson(json, RepositoryDTO::class.java)
    }

    fun toJSON() : String {
        return GsonBuilder().setPrettyPrinting().create().toJson(this)
    }
}