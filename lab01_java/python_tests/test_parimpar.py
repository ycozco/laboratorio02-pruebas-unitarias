import unittest

class ParImpar:
    @staticmethod
    def identificar(lista):
        return ["Par" if n % 2 == 0 else "Impar" for n in lista]


class TestParImpar(unittest.TestCase):
    def test_identificar_mixto(self):
        self.assertEqual(ParImpar.identificar([1,2,3,4,5]), ["Impar", "Par", "Impar", "Par", "Impar"])

    def test_identificar_solo_pares(self):
        self.assertEqual(ParImpar.identificar([2,4,6]), ["Par", "Par", "Par"])

    def test_identificar_solo_impares(self):
        self.assertEqual(ParImpar.identificar([1,3,5]), ["Impar", "Impar", "Impar"])

    def test_identificar_con_cero(self):
        self.assertEqual(ParImpar.identificar([0, 1, 2]), ["Par", "Impar", "Par"])

    def test_identificar_negativos(self):
        self.assertEqual(ParImpar.identificar([-2, -3, -4]), ["Par", "Impar", "Par"])

    def test_identificar_lista_vacia(self):
        self.assertEqual(ParImpar.identificar([]), [])

if __name__ == '__main__':
    unittest.main()
