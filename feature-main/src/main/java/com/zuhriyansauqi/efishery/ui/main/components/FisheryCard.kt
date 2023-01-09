package com.zuhriyansauqi.efishery.ui.main.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zuhriyansauqi.efishery.core_ui.ui.theme.EfisheryTheme
import com.zuhriyansauqi.efishery.domain.model.Fishery
import com.zuhriyansauqi.efishery.ui.main.R
import compose.icons.FeatherIcons
import compose.icons.feathericons.*

@Composable
fun FisheryCard(
  item: Fishery,
  onEditClick: (Fishery) -> Unit = {},
  onDeleteClick: (Fishery) -> Unit = {}
) {
  val openDeleteDialog = remember { mutableStateOf(false) }

  if (openDeleteDialog.value) {
    AlertDialog(
      onDismissRequest = {
        openDeleteDialog.value = false
      },
      icon = { Icon(FeatherIcons.Trash, contentDescription = null) },
      title = {
        Text(text = stringResource(id = R.string.delete_alert_title))
      },
      text = {
        Text(
          text = stringResource(id = R.string.delete_alert_subtitle)
        )
      },
      confirmButton = {
        TextButton(
          onClick = {
            openDeleteDialog.value = false
          }
        ) {
          Text(
            text = stringResource(id = R.string.close_button),
          )
        }
      },
      dismissButton = {
        TextButton(
          onClick = {
            onDeleteClick.invoke(item)
            openDeleteDialog.value = false
          }
        ) {
          Text(
            text = stringResource(id = R.string.delete_button),
            color = MaterialTheme.colorScheme.error
          )
        }
      }
    )
  }
  Card(
    colors = CardDefaults.cardColors(
      containerColor = MaterialTheme.colorScheme.surfaceVariant,
    ),
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 6.dp)
  ) {

    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 16.dp, horizontal = 12.dp)
    ) {

      FisheryAttribute(
        icon = FeatherIcons.Package,
        text = item.commodityFormatted
      )
      FisheryAttribute(
        icon = FeatherIcons.MapPin,
        text = item.location
      )
      FisheryAttribute(
        icon = FeatherIcons.DollarSign,
        text = item.priceFormatted
      )

      Spacer(modifier = Modifier.height(12.dp))

      Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
      ) {
        OutlinedButton(onClick = { onEditClick(item) }) {
          Icon(
            imageVector = FeatherIcons.Edit,
            contentDescription = null,
            modifier = Modifier.size(12.dp)
          )
          Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
          Text(
            text = stringResource(id = R.string.edit_button),
            style = MaterialTheme.typography.labelSmall
          )
        }
        Spacer(modifier = Modifier.size(8.dp))
        Button(
          colors = ButtonDefaults.buttonColors(
            contentColor = MaterialTheme.colorScheme.onError,
            containerColor = MaterialTheme.colorScheme.error
          ),
          onClick = { openDeleteDialog.value = true }) {
          Icon(
            imageVector = FeatherIcons.Trash,
            contentDescription = null,
            modifier = Modifier.size(12.dp),
          )
          Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
          Text(
            text = stringResource(id = R.string.delete_button),
            style = MaterialTheme.typography.labelSmall,
          )
        }
      }
    }
  }
}

@Composable
private fun FisheryAttribute(
  icon: ImageVector,
  text: String
) {
  Row(
    modifier = Modifier
      .height(32.dp)
      .fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
  ) {

    Icon(
      imageVector = icon,
      contentDescription = null,
      tint = MaterialTheme.colorScheme.onSurfaceVariant,
      modifier = Modifier
        .height(16.dp)
        .width(16.dp)
    )

    Spacer(modifier = Modifier.width(8.dp))

    Text(
      text = text,
      style = MaterialTheme.typography.bodySmall,
      color = MaterialTheme.colorScheme.onSurfaceVariant,
      modifier = Modifier.fillMaxWidth()
    )
  }
}

@Preview("Fishery Card")
@Composable
fun Preview_FisheryCard() {
  EfisheryTheme {
    val dummy = Fishery(
      uuid = "b534039a-3f2e-42a0-8c3a-e6fdf50736d6",
      commodity = "NILA MERAH",
      province = "SULAWESI BARAT",
      city = "MAMUJU UTARA",
      size = 30,
      price = 54000,
      timestamp = 1646953716725
    )
    FisheryCard(dummy)
  }
}
