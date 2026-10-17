package com.example.questtugasuserinput.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.questtugasuserinput.R

/**
 * Header section with title and subtitle using resources.
 */
@Composable
fun FormHeaderSection() {
    Text(
        text = stringResource(id = R.string.form_title),
        fontSize = dimensionResource(id = R.dimen.font_title).value.sp,
        fontWeight = FontWeight.Bold,
        color = colorResource(id = R.color.color_text_title),
        textAlign = TextAlign.Center
    )

    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_8)))

    Text(
        text = stringResource(id = R.string.form_subtitle),
        fontSize = dimensionResource(id = R.dimen.font_subtitle).value.sp,
        color = colorResource(id = R.color.color_subtitle_gray),
        textAlign = TextAlign.Center
    )
}

/**
 * First Name and Last Name inputs laid out in a responsive Row.
 */
@Composable
fun NameInputSection(
    firstName: String,
    onFirstNameChange: (String) -> Unit,
    lastName: String,
    onLastNameChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.field_row_gap))
    ) {
        OutlinedTextField(
            value = firstName,
            onValueChange = onFirstNameChange,
            modifier = Modifier.weight(1f),
            label = { Text(text = stringResource(id = R.string.first_name_label)) },
            singleLine = true,
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.field_corner_radius)),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(id = R.color.color_field_focused_border),
                unfocusedBorderColor = colorResource(id = R.color.color_field_unfocused_border),
                focusedLabelColor = colorResource(id = R.color.color_field_focused_border),
                unfocusedLabelColor = colorResource(id = R.color.color_subtitle_gray)
            )
        )

        OutlinedTextField(
            value = lastName,
            onValueChange = onLastNameChange,
            modifier = Modifier.weight(1f),
            label = { Text(text = stringResource(id = R.string.last_name_label)) },
            singleLine = true,
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.field_corner_radius)),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(id = R.color.color_field_focused_border),
                unfocusedBorderColor = colorResource(id = R.color.color_field_unfocused_border),
                focusedLabelColor = colorResource(id = R.color.color_field_focused_border),
                unfocusedLabelColor = colorResource(id = R.color.color_subtitle_gray)
            )
        )
    }
}

/**
 * Full-width email input field.
 */
@Composable
fun EmailInputSection(
    email: String,
    onEmailChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = email,
        onValueChange = onEmailChange,
        modifier = modifier.fillMaxWidth(),
        label = { Text(text = stringResource(id = R.string.email_label)) },
        singleLine = true,
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.field_corner_radius)),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.color_field_focused_border),
            unfocusedBorderColor = colorResource(id = R.color.color_field_unfocused_border),
            focusedLabelColor = colorResource(id = R.color.color_field_focused_border),
            unfocusedLabelColor = colorResource(id = R.color.color_subtitle_gray)
        )
    )
}
