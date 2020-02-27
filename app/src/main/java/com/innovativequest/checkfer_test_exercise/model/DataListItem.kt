package com.innovativequest.checkfer_test_exercise.model

import androidx.room.Entity
import androidx.room.Index
import com.google.gson.annotations.SerializedName

@Entity(
	indices = [
		Index("id"),
		Index("name")],
	primaryKeys = ["id"]
)
data class DataListItem(

	@field:SerializedName("member_since")
	val memberSince: String? = null,

	@field:SerializedName("rating")
	val rating: Double? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("profile_image")
	val profileImage: String? = null,

	@field:SerializedName("average_response_time")
	val averageResponseTime: Int? = null,

	@field:SerializedName("sirname")
	val sirname: String? = null,

	@field:SerializedName("rate")
	val rate: Double? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("ranking")
	val ranking: String? = null,

	@field:SerializedName("num_reviews")
	val numReviews: Int? = null,

	@field:SerializedName("information")
	val information: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("status")
	val status: String? = null
)