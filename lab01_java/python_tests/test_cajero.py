import unittest

class CajeroAutomatico:
    def __init__(self, saldo_inicial):
        if saldo_inicial < 0:
            raise ValueError("El saldo inicial no puede ser negativo")
        self.saldo = saldo_inicial
    def test_saldo_inicial_negativo(self):
        with self.assertRaises(ValueError):
            CajeroAutomatico(-100)
    def consultar_saldo(self):
        return self.saldo
    def depositar(self, monto):
        if monto <= 0:
            raise ValueError("El monto a depositar debe ser positivo")
        self.saldo += monto
        return True
    def retirar(self, monto):
        if monto <= 0:
            raise ValueError("El monto a retirar debe ser positivo")
        if monto > self.saldo:
            raise ValueError("Fondos insuficientes")
        self.saldo -= monto
        return True


class TestCajeroAutomatico(unittest.TestCase):
    def test_saldo_inicial(self):
        cajero = CajeroAutomatico(1000)
        self.assertEqual(cajero.consultar_saldo(), 1000)

    def test_depositar_valido(self):
        cajero = CajeroAutomatico(100)
        self.assertTrue(cajero.depositar(50))
        self.assertEqual(cajero.consultar_saldo(), 150)


    def test_depositar_cero(self):
        cajero = CajeroAutomatico(100)
        with self.assertRaises(ValueError):
            cajero.depositar(0)
        self.assertEqual(cajero.consultar_saldo(), 100)

    def test_depositar_negativo(self):
        cajero = CajeroAutomatico(100)
        with self.assertRaises(ValueError):
            cajero.depositar(-10)
        self.assertEqual(cajero.consultar_saldo(), 100)

    def test_retirar_valido(self):
        cajero = CajeroAutomatico(200)
        self.assertTrue(cajero.retirar(50))
        self.assertEqual(cajero.consultar_saldo(), 150)


    def test_retirar_cero(self):
        cajero = CajeroAutomatico(200)
        with self.assertRaises(ValueError):
            cajero.retirar(0)
        self.assertEqual(cajero.consultar_saldo(), 200)

    def test_retirar_negativo(self):
        cajero = CajeroAutomatico(200)
        with self.assertRaises(ValueError):
            cajero.retirar(-5)
        self.assertEqual(cajero.consultar_saldo(), 200)

    def test_retirar_mayor_que_saldo(self):
        cajero = CajeroAutomatico(100)
        with self.assertRaises(ValueError):
            cajero.retirar(200)
        self.assertEqual(cajero.consultar_saldo(), 100)

if __name__ == '__main__':
    unittest.main()
