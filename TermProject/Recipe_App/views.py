from django.shortcuts import render, get_object_or_404
# from django.http import HttpResponse
# from django.template import loader
# from django.http import Http404

# Create your views here.
from .models import Recipe_List


def index(request):
    all_recipes = Recipe_List.objects.order_by('id')[:]
    #    template = loader.get_template('Recipe_App/index.html')
    context = {
        'all_recipes': all_recipes,
    }
    #    return HttpResponse(template.render(context, request))
    return render(request, 'Recipe_App/index.html', context)


#    output = '\n '.join([str(i + 1) + '.) ' + q.name_text for i, q in enumerate(all_recipes)])
#    return HttpResponse(output)

def detail(request, Recipe_List_id):
    recipe = get_object_or_404(Recipe_List, pk=Recipe_List_id)
    instructions = recipe.instruction_text
    instruction_list = instructions.split('\n')
    #    try:
    #        recipe = Recipe_List.objects.get(pk = Recipe_List_id)
    #    except Recipe_List.DoesNotExist:
    #        raise Http404("Recipe does not exist")
    return render(request, 'Recipe_App/detail.html', {'recipe': recipe, 'instruction_list': instruction_list})
#    return HttpResponse('You\'re looking at recipe number ' + str(Recipe_List_id))
