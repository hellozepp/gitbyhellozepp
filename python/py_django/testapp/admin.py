from django.contrib import admin

# Register your models here.
from testapp.models import User, UserPhoto, Contact, Tag

admin.site.register(User)
admin.site.register(UserPhoto)
admin.site.register(Tag)


class ContactAdmin(admin.ModelAdmin):
    fields = ('name', 'email')

class ContactAdmin1(admin.ModelAdmin):
    fieldsets = (
        ['Main',{
            'fields':('name','email'),
        }],
        ['Advance',{
            'classes': ('collapse',), # CSS
            'fields': ('age',),
        }]
    )


class TagInline(admin.TabularInline):
    model = Tag


class ContactAdmin2(admin.ModelAdmin):
    search_fields = ('name','age', 'email',)#search
    list_filter = ('name','age', 'email',)#search
    list_display = ('name', 'age', 'email')  # list
    list_editable =('age',) #可编辑
    ordering = ('name',)#orderby
    list_per_page = 2 #分页
    inlines = [TagInline]  # Inline
    fieldsets = (
        ['Main', {
            'fields': ('name', 'email'),
        }],
        ['Advance', {
            'classes': ('collapse',),
            'fields': ('age',),
        }]

    )

admin.site.register(Contact, ContactAdmin2)
