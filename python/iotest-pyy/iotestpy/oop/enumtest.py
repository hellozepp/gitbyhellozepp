from enum import IntEnum, unique


@unique
class Season(IntEnum):
    spring=1
    summer=2
    autumn=3
    winter=4
    # winter2=4 #使用了@unique 不允许重复

# print(Season())#enum不能定义对象
print(Season.spring)
print(Season(2))

print(Season.winter.value)
print(Season["autumn"].value)

# =============================================================
print("==========================================")

for s in Season:
    print(s)