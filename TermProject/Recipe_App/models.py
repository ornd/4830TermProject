from django.db import models

# Create your models here.
class Recipe_List(models.Model):
    name_text = models.CharField(max_length=30)
    ingredient_text = models.TextField()
    instruction_text = models.TextField()