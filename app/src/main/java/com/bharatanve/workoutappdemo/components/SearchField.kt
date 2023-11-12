package com.bharatanve.workoutappdemo.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bharatanve.workoutappdemo.Constants
import com.bharatanve.workoutappdemo.ui.theme.poppinsFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField(
    searchString : String,
    onSearchStringChange : (String) -> Unit,
    placeholder: String,
    onTrailingIconClick : () -> Unit,
    onLeadingIconClick : () -> Unit,
    leadingIconId : Int,
    trailingIconId : Int,
    modifier: Modifier = Modifier
) {

    Card (
        elevation = CardDefaults.cardElevation(1.dp),
        shape = RoundedCornerShape(25.dp),
        modifier = Modifier.height(50.dp)
        ){
        TextField(
            modifier = modifier.fillMaxWidth().fillMaxHeight(),
            value = searchString,
            onValueChange = { onSearchStringChange(it) } ,
            textStyle = TextStyle(
                fontSize = Constants.searchFieldFontSize.sp,
                fontFamily = poppinsFontFamily,
                fontWeight = FontWeight(300),
                color = Color.Black
            ),
            placeholder = {
                Text(
                    text = placeholder,
                    style = TextStyle(
                        fontSize = Constants.searchFieldFontSize.sp,
                        fontFamily = poppinsFontFamily
                    ),
                    fontWeight = FontWeight(300),
                    color = Color.Black,
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            trailingIcon = {
                IconButton(onClick = { onTrailingIconClick() }) {
                    Icon(
                        painterResource(id = trailingIconId),
                        contentDescription = "trailing icon",
                        tint = Color.Black,
                        modifier = Modifier.size(20.dp)
                    )
                }
            },
            leadingIcon = {
                IconButton(onClick = { onLeadingIconClick() }) {
                    Icon(
                        painterResource(id = leadingIconId),
                        contentDescription = "leading icon",
                        tint = Color.Black,
                        modifier = Modifier.size(20.dp)


                    )
                }
            },
            visualTransformation = VisualTransformation.None,
            shape = RoundedCornerShape(15.dp),
            singleLine = true
            )
    }

}