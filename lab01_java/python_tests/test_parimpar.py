import unittest

class ParImpar:
    @staticmethod
    def identificar(lista):
        return ["Par" if n % 2 == 0 else "Impar" for n in lista]

class TestParImpar(unittest.TestCase):
    def test_identificar(self):
        self.assertEqual(ParImpar.identificar([1,2,3,4,5]), ["Impar", "Par", "Impar", "Par", "Impar"])
        self.assertEqual(ParImpar.identificar([2,4,6]), ["Par", "Par", "Par"])
        self.assertEqual(ParImpar.identificar([1,3,5]), ["Impar", "Impar", "Impar"])

if __name__ == '__main__':
    unittest.main()
