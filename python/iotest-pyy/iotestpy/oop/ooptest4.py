class Score:

    def __init__(self,zh_Score,math_Score):
        self.zh_Score=zh_Score
        self.math_Score=math_Score

    def __add__(self, other):
        return Score(self.zh_Score+other.zh_Score,self.math_Score+other.math_Score)

    def __sub__(self, other):
        return Score(self.zh_Score - other.zh_Score, self.math_Score - other.math_Score)

    def __mul__(self, other):
        return Score(self.zh_Score * other.zh_Score, self.math_Score * other.math_Score)

    def __truediv__(self, other):
        return Score(self.zh_Score / other.zh_Score, self.math_Score / other.math_Score)

    def __floordiv__(self, other):
        return Score(self.zh_Score // other.zh_Score, self.math_Score // other.math_Score)

    def __str__(self):
        return "Totle zh_Score is :"+str(self.zh_Score)+" and math_Score is: "+str(self.math_Score)

if __name__ == "__main__":
    s1=Score(100,99)
    s2=Score(98,100)
    s3=s1 + s2
    print(s3)
