package com.example.questtugasuserinput.ui.theme

/**
 * Data model representing the user input state in the Biodata form.
 */
data class BiodataFormData(
    val firstName: String = "",
    val lastName: String = "",
    val email: String = "",
    val birthDate: String = "",
    val experience: String = "",
    val isAndroidSelected: Boolean = false,
    val isUiUxSelected: Boolean = false,
    val isWebSelected: Boolean = false,
    val isSubmitted: Boolean = false
) {
    /**
     * Checks whether the basic required fields have been filled.
     */
    val isValid: Boolean
        get() = firstName.isNotBlank() &&
                lastName.isNotBlank() &&
                email.isNotBlank() &&
                birthDate.isNotBlank() &&
                experience.isNotBlank() &&
                (isAndroidSelected || isUiUxSelected || isWebSelected)
}

