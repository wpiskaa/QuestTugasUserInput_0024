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

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.ui.Alignment

/**
 * Skill selection section with checkboxes for Android, UI/UX, and Web.
 */
@Composable
fun SkillSelectionSection(
    isAndroidSelected: Boolean,
    onAndroidChange: (Boolean) -> Unit,
    isUiUxSelected: Boolean,
    onUiUxChange: (Boolean) -> Unit,
    isWebSelected: Boolean,
    onWebChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(id = R.string.skill_section_title),
            fontSize = dimensionResource(id = R.dimen.font_label).value.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.color_text_label)
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_6)))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SkillCheckboxItem(
                label = stringResource(id = R.string.skill_android),
                checked = isAndroidSelected,
                onCheckedChange = onAndroidChange
            )
            SkillCheckboxItem(
                label = stringResource(id = R.string.skill_uiux),
                checked = isUiUxSelected,
                onCheckedChange = onUiUxChange
            )
            SkillCheckboxItem(
                label = stringResource(id = R.string.skill_web),
                checked = isWebSelected,
                onCheckedChange = onWebChange
            )
        }
    }
}

/**
 * Single clickable checkbox item with label.
 */
@Composable
fun SkillCheckboxItem(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.clickable { onCheckedChange(!checked) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = colorResource(id = R.color.color_checkbox_checked),
                uncheckedColor = colorResource(id = R.color.color_field_unfocused_border)
            )
        )
        Text(
            text = label,
            fontSize = dimensionResource(id = R.dimen.font_checkbox).value.sp,
            color = colorResource(id = R.color.color_text_label)
        )
    }
}

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider

/**
 * Summary card presenting the submitted biodata information.
 */
@Composable
fun ResultSummaryCard(
    formData: BiodataFormData,
    modifier: Modifier = Modifier
) {
    val androidSkill = stringResource(id = R.string.skill_android)
    val uiuxSkill = stringResource(id = R.string.skill_uiux)
    val webSkill = stringResource(id = R.string.skill_web)
    val noSkill = stringResource(id = R.string.result_none)

    val skillsList = buildList {
        if (formData.isAndroidSelected) add(androidSkill)
        if (formData.isUiUxSelected) add(uiuxSkill)
        if (formData.isWebSelected) add(webSkill)
    }.ifEmpty { listOf(noSkill) }.joinToString(", ")

    ElevatedCard(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.result_card_corner_radius)),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = dimensionResource(id = R.dimen.result_card_elevation)
        ),
        colors = CardDefaults.elevatedCardColors(
            containerColor = colorResource(id = R.color.color_result_card_bg)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.result_card_padding))
        ) {
            Text(
                text = stringResource(id = R.string.result_title),
                fontSize = dimensionResource(id = R.dimen.font_result_header).value.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.color_result_accent)
            )

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_10)))
            HorizontalDivider(
                thickness = dimensionResource(id = R.dimen.divider_tipis),
                color = colorResource(id = R.color.color_result_card_border)
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_10)))

            ResultRow(
                label = stringResource(id = R.string.result_name_label),
                value = "${formData.firstName} ${formData.lastName}".trim()
            )
            ResultRow(
                label = stringResource(id = R.string.result_email_label),
                value = formData.email
            )
            ResultRow(
                label = stringResource(id = R.string.result_dob_label),
                value = formData.birthDate
            )
            ResultRow(
                label = stringResource(id = R.string.result_exp_label),
                value = formData.experience
            )
            ResultRow(
                label = stringResource(id = R.string.result_skills_label),
                value = skillsList
            )
        }
    }
}

/**
 * Reusable key-value row inside ResultSummaryCard.
 */
@Composable
fun ResultRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = dimensionResource(id = R.dimen.space_4)),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontSize = dimensionResource(id = R.dimen.font_result_body).value.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.color_text_label)
        )
        Text(
            text = value,
            fontSize = dimensionResource(id = R.dimen.font_result_body).value.sp,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.color_subtitle_gray)
        )
    }
}
