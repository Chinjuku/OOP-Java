class ProbHash:
    def __init__(self, cap):
        self.hashtable = cap*[None]
        self.n = cap

    def hashFunction(self, mykey):
        return mykey % self.n

    def rehashFunciton(self, hashkey):
        return (hashkey + 1) % self.n

    def insertData(self, student_obj):
        key = self.hashFunction(student_obj.getid())
        num = 0
        while True:
            num+=1
            if self.hashtable[key] == None:
                self.hashtable[key] = student_obj
                print("Insert "+str(student_obj.getid())+ "at index "+str(key))
                break
            elif num > self.n:
                print("Don't know")
                break
            else:
                key = self.rehashFunciton(key)

    def searchData(self, key):
        hashkey = self.hashFunction(key)
        num = 0
        while True:
            num+=1
            if self.hashtable[hashkey] != None:
                if key == self.hashtable[hashkey].getid():
                    print("Found "+str(key)+" at index "+str(hashkey))
                    return self.hashtable[hashkey]
                elif num > self.n:
                    print(str(key)+" does not exist.")
                    break
                else:
                    hashkey = self.rehashFunciton(key)
            elif num > self.n:
                print(str(key)+" does not exist.")
                break
            else:
                print(str(key)+" does not exist.")
                break

class Student:
    def __init__(self, id, name, gpa):
        self.id = id
        self.name = name
        self.gpa = gpa
    def getid(self):
        return self.id
    def getName(self):
        return self.name
    def getGpa(self):
        return self.gpa
    def printDetails(self):
        print("ID : "+str(self.getid())+"\nName : "+str(self.getName())+"\nGPA : "+str(self.getGpa()))
            
s1 = Student(65070001, "Sandee Boonmak", 3.05)
s2 = Student(65070077, "SomsakJaidee", 2.78)
s3 = Student(65070021, "SomsriJaiyai", 3.44)
s4 = Student(65070042, "SommaiMeeboon", 2.89)

myHash= ProbHash(3) 
myHash.insertData(s1) 
myHash.insertData(s2) 
myHash.insertData(s3) 
myHash.insertData(s4)

std = myHash.searchData(65070077) 
std.printDetails() 
print("-------------------------") 
std = myHash.searchData(65070021) 
std.printDetails() 
print("-------------------------") 
std = myHash.searchData(65070042) 
std.printDetails()
print("-------------------------") 
std = myHash.searchData(65070032)