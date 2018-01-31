from django.db import models

# Create your models here.
from testapp.storage import ImageStorage


class User(models.Model):
    uid=models.IntegerField(primary_key=True)
    username=models.CharField(max_length=30)
    password=models.CharField(max_length=30)
    regtime=models.DateTimeField()

class UserPhoto(models.Model):
    username = models.CharField(max_length=30)
    headImg = models.FileField(upload_to='./upload/',storage=ImageStorage())


class Contact(models.Model):
    name = models.CharField(max_length=200)
    age = models.IntegerField(default=0)
    email = models.EmailField()

    def __unicode__(self):
        return self.name


class Tag(models.Model):
    contact = models.ForeignKey(Contact)
    name = models.CharField(max_length=50)

    def __unicode__(self):
        return self.name