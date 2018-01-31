from django.forms import ModelForm
from django import forms
from testapp.models import UserPhoto

# class UserForm(ModelForm):
#     class Meta:
#         model=UserPhoto
#         fields='__all__' #导入所有字段

class UserForm(forms.Form):
    username = forms.CharField()
    headImg = forms.FileField()