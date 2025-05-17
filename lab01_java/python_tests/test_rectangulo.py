import unittest



class Rectangulo:
    @staticmethod
    def area(base, altura):
        if base < 0 or altura < 0:
            raise ValueError("Base y altura deben ser no negativas")
        return base * altura



class TestRectangulo(unittest.TestCase):
    def test_area_enteros_positivos(self):
        self.assertEqual(Rectangulo.area(5, 3), 15)
        self.assertEqual(Rectangulo.area(10, 2), 20)
        self.assertEqual(Rectangulo.area(1, 1), 1)
        self.assertEqual(Rectangulo.area(100, 100), 10000)

    def test_area_decimales(self):
        self.assertEqual(Rectangulo.area(2.5, 4), 10)
        self.assertAlmostEqual(Rectangulo.area(1.1, 2.2), 2.42, places=2)
        self.assertEqual(Rectangulo.area(0.5, 0.5), 0.25)
        self.assertAlmostEqual(Rectangulo.area(3.3, 3), 9.9, places=2)

    def test_area_cero(self):
        self.assertEqual(Rectangulo.area(0, 10), 0)
        self.assertEqual(Rectangulo.area(10, 0), 0)
        self.assertEqual(Rectangulo.area(0, 0), 0)

    def test_area_casos_limite(self):
        import sys
        self.assertEqual(Rectangulo.area(sys.float_info.max, 1), sys.float_info.max)
        self.assertEqual(Rectangulo.area(sys.float_info.min, 1), sys.float_info.min)
        self.assertEqual(Rectangulo.area(sys.float_info.max, 0), 0)
        self.assertEqual(Rectangulo.area(sys.float_info.min, 0), 0)

    def test_area_base_negativa_lanza_excepcion(self):
        with self.assertRaises(ValueError):
            Rectangulo.area(-1, 5)

    def test_area_altura_negativa_lanza_excepcion(self):
        with self.assertRaises(ValueError):
            Rectangulo.area(5, -1)

    def test_area_base_y_altura_negativa_lanza_excepcion(self):
        with self.assertRaises(ValueError):
            Rectangulo.area(-2, -2)


if __name__ == '__main__':
    unittest.main()
