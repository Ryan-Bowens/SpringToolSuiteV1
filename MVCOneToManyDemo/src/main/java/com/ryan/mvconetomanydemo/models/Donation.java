package com.ryan.mvconetomanydemo.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

	@Entity
	@Table(name = "donation")
	public class Donation {

		// Attributes
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		
		@Size(min=3, max=255)
		@NotEmpty(message="donationName is required")
//		@NotBlank wont accept empty spaces
//		@NotEmpty wont accept an empty field
		private String donationName;
		
//		NEW ---- MANY TO ONE ----
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="user_id")
		private User donor;
		
		@Min(0)
		@NotNull
		private Integer quantity;
		
		@Column(updatable = false)
		private Date createdAt;

		private Date updatedAt;
		
		public Donation() {}

		
//		right click -> source -> generate getters/setters (only get for id, created, updated)
		public String getDonationName() {
			return donationName;
		}


		public void setDonationName(String donationName) {
			this.donationName = donationName;
		}

//		NEW ---- MANY TO ONE ----
		public User getDonor() {
			return donor;
		}

//		NEW ---- MANY TO ONE ----
		public void setDonor(User donor) {
			this.donor = donor;
		}

		
		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public Date getUpdatedAt() {
			return updatedAt;
		}

		@PrePersist //adds the created at date and time to sql on creation
		protected void onCreate() {
			this.createdAt = new Date();
		}
		
		@PreUpdate //add the updated at date and time when being updated
		protected void onUpdate() {
			this.updatedAt = new Date();
		}
		

	}
