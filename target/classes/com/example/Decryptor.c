using System;
using System.Security.Cryptography;
using System.Text;

public class Decryptor {
    public static string Decrypt(string encryptedText, string keyStr, string ivStr) {
        byte[] keyArr = Convert.FromBase64String(keyStr);
        byte[] ivArr = Convert.FromBase64String(ivStr);

        using (RijndaelManaged aes = new RijndaelManaged()) {
            aes.BlockSize = 128; // Block Size
            aes.KeySize = 256; // Key Size
            aes.Mode = CipherMode.CBC; // Modalità CBC
            aes.Padding = PaddingMode.PKCS7; // Padding

            aes.IV = ivArr;
            aes.Key = keyArr;

            ICryptoTransform decrypto = aes.CreateDecryptor();

            byte[] encryptedBytes = Convert.FromBase64String(encryptedText);
            byte[] decryptedData = decrypto.TransformFinalBlock(encryptedBytes, 0, encryptedBytes.Length);
            return Encoding.UTF8.GetString(decryptedData);
        }
    }
}
