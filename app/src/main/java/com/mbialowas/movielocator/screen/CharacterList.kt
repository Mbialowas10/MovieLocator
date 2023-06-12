package com.mbialowas.movielocator.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mbialowas.movielocator.CharacterDataSet
import com.mbialowas.moviefinder.models.Character


@Composable
fun CharacterList(){

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Characters from HP", fontWeight = FontWeight.Bold)

       LazyColumn{
           items(CharacterDataSet.characterList){
               person ->
               Character(character = person)
               Log.i("Actor", person.name)
           }
       }
    }
}




@Composable
fun Character(character: Character){
    val context = LocalContext.current
    Box(modifier = Modifier
        .height(100.dp)
        .padding(5.dp)
    ) {


        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(top = 16.dp, start = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Row(modifier = Modifier
                .fillMaxWidth().fillMaxHeight().clickable{
                    Toast.makeText(context, "You clicked ${character.actor}. ",Toast.LENGTH_SHORT).show()
                }) {
                AsyncImage(modifier = Modifier
                    .clip(CircleShape),
                    model = character.image  , contentDescription = character.actor)
                Column() {
                    Text(
                        text = character.name,
                        color= Color.Red,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = character.actor,
                        color= Color.Blue,
                        fontWeight = FontWeight.SemiBold
                    )
                }

            }



        }
    }
}