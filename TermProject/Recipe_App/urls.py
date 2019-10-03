from django.urls import path
from . import views

app_name = 'Recipe_App'
urlpatterns = [
    path('', views.index, name = 'index'),
    path('<int:Recipe_List_id>/', views.detail, name = 'detail'),
]