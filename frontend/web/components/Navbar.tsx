import { Link } from "expo-router";
import { StyleSheet, View } from "react-native";

export default function Navbar() {
  return (
    <View style={styles.container}>
      <Link href="/" style={styles.link}>Home</Link>
      <Link href="/signup" style={styles.link}>Signup</Link>
      <Link href="/login" style={styles.link}>Login</Link>
      <Link href="/admin" style={styles.link}>Admin</Link>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    justifyContent: "center",
    alignItems: "center",
    flexDirection: "row",
    backgroundColor: "gray",
    padding: 10,
    borderRadius: 6,
  },
  link: {
    marginLeft: 12,
    marginRight: 12,
    padding: 4,
    borderRadius: 6,
    backgroundColor: "white",
  },
});