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

import android.app.DatePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import java.util.Calendar

/**
 * Section pairing Date of Birth and Experience inputs in a side-by-side Row.
 */
@Composable
fun DateAndExperienceSection(
    birthDate: String,
    onBirthDateChange: (String) -> Unit,
    experience: String,
    onExperienceChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.field_row_gap))
    ) {
        DateOfBirthField(
            birthDate = birthDate,
            onBirthDateChange = onBirthDateChange,
            modifier = Modifier.weight(1f)
        )

        ExperienceDropdownField(
            experience = experience,
            onExperienceChange = onExperienceChange,
            modifier = Modifier.weight(1f)
        )
    }
}

/**
 * Date of Birth picker field with calendar icon and DatePickerDialog.
 */
@Composable
fun DateOfBirthField(
    birthDate: String,
    onBirthDateChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val datePickerDialog = remember {
        DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                onBirthDateChange(
                    String.format(
                        java.util.Locale.getDefault(),
                        "%02d/%02d/%04d",
                        dayOfMonth,
                        month + 1,
                        year
                    )
                )
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
    }

    Box(modifier = modifier) {
        OutlinedTextField(
            value = birthDate,
            onValueChange = onBirthDateChange,
            modifier = Modifier.fillMaxWidth(),
            readOnly = true,
            label = { Text(text = stringResource(id = R.string.birth_date_label)) },
            singleLine = true,
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_calendar),
                    contentDescription = stringResource(id = R.string.desc_calendar_icon),
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.icon_size_small))
                        .clickable { datePickerDialog.show() },
                    tint = colorResource(id = R.color.color_field_border)
                )
            },
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.field_corner_radius)),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(id = R.color.color_field_focused_border),
                unfocusedBorderColor = colorResource(id = R.color.color_field_unfocused_border),
                focusedLabelColor = colorResource(id = R.color.color_field_focused_border),
                unfocusedLabelColor = colorResource(id = R.color.color_subtitle_gray)
            )
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .clickable { datePickerDialog.show() }
        )
    }
}

/**
 * Dropdown selector for Experience levels.
 */
@Composable
fun ExperienceDropdownField(
    experience: String,
    onExperienceChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val options = listOf(
        stringResource(id = R.string.exp_beginner),
        stringResource(id = R.string.exp_intermediate),
        stringResource(id = R.string.exp_advanced),
        stringResource(id = R.string.exp_expert)
    )

    Box(modifier = modifier) {
        OutlinedTextField(
            value = experience,
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            readOnly = true,
            label = { Text(text = stringResource(id = R.string.experience_label)) },
            singleLine = true,
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_drop_down),
                    contentDescription = stringResource(id = R.string.desc_dropdown_icon),
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.icon_size_small))
                        .clickable { expanded = !expanded },
                    tint = colorResource(id = R.color.color_field_border)
                )
            },
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.field_corner_radius)),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = colorResource(id = R.color.color_field_focused_border),
                unfocusedBorderColor = colorResource(id = R.color.color_field_unfocused_border),
                focusedLabelColor = colorResource(id = R.color.color_field_focused_border),
                unfocusedLabelColor = colorResource(id = R.color.color_subtitle_gray)
            )
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .clickable { expanded = !expanded }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(colorResource(id = R.color.color_card_floating_bg))
        ) {
            options.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = item,
                            fontSize = dimensionResource(id = R.dimen.font_label).value.sp,
                            color = colorResource(id = R.color.color_text_label)
                        )
                    },
                    onClick = {
                        onExperienceChange(item)
                        expanded = false
                    }
                )
            }
        }
    }
}
