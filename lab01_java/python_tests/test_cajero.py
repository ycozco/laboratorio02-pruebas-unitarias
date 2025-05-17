import unittest

class CajeroAutomatico:
    def __init__(self, saldo_inicial):
        self.saldo = saldo_inicial
    def consultar_saldo(self):
        return self.saldo
    def depositar(self, monto):
        if monto > 0:
            self.saldo += monto
            return True
        return False
    def retirar(self, monto):
        if monto > 0 and monto <= self.saldo:
            self.saldo -= monto
            return True
        return False

class TestCajeroAutomatico(unittest.TestCase):
    def test_depositar_y_consultar_saldo(self):
        cajero = CajeroAutomatico(100)
        self.assertTrue(cajero.depositar(50))
        self.assertEqual(cajero.consultar_saldo(), 150)
        self.assertFalse(cajero.depositar(-10))
    def test_retirar(self):
        cajero = CajeroAutomatico(200)
        self.assertTrue(cajero.retirar(50))
        self.assertEqual(cajero.consultar_saldo(), 150)
        self.assertFalse(cajero.retirar(200))
        self.assertFalse(cajero.retirar(-5))

if __name__ == '__main__':
    unittest.main()
